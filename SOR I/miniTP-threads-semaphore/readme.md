## Test

```bash
  gcc asado.c -o asado -lpthread
```
```bash
  ./asado
```

`Semaforos`
```c
sem_t todos_invitados_sentados;
sem_t manucho_puede_sentarse;
sem_t mozos_pueden_servir;
sem_t empezar_a_comer;
sem_t hace_pregunta;
sem_t recibe_respuesta;
sem_t manucho_puede_irse;
sem_t invitados_pueden_irse;
```


`Primitivas`
```c
void sentarse(char who);
void servirComida();
void enojarse();
void levantarse(char who);
void lanzar_pregunta_mundialista();
void lanzar_respuesta_mundialista();
```

`Hilo manucho`
```c
void *hilo_manucho(void *arg){

    sem_wait(&manucho_puede_sentarse);
    sentarse('m');

    for (int i=0; i<comensales;i++){
        sem_post(&mozos_pueden_servir);
    }

    sem_wait(&empezar_a_comer);
    printf(ANSI_COLOR_GREEN "MANUCHO esta comiendo" ANSI_COLOR_RESET "\n");
    simularTarea(3);
    printf(ANSI_COLOR_CYAN "MANUCHO termino de comer" ANSI_COLOR_RESET "\n");

    lanzar_pregunta_mundialista();
    sem_post(&hace_pregunta);
    sem_wait(&recibe_respuesta);
    enojarse();
    sem_wait(&manucho_puede_irse);
    levantarse('m');
    sem_post(&invitados_pueden_irse);
}
```

`Hilo invitados`
```c
void *hilo_invitados(void *arg){

    sem_wait(&todos_invitados_sentados);
    sentarse('i');
    invidatosSentados++;
    
    if(invidatosSentados == cantidadInvitados ){
        sem_post(&manucho_puede_sentarse);
    }

    sem_post(&todos_invitados_sentados);

    sem_wait(&empezar_a_comer);
    printf(ANSI_COLOR_GREEN "Un INVITADO esta comiendo" ANSI_COLOR_RESET "\n");
    simularTarea(3);
    printf(ANSI_COLOR_MAGENTA "Un INVITADO termino de comer" ANSI_COLOR_RESET "\n");


    if(!preguntaRespondida){
        sem_wait(&hace_pregunta);
        preguntaRespondida = 1;
        lanzar_respuesta_mundialista();
        sem_post(&recibe_respuesta);
        sem_post(&manucho_puede_irse);
    }
    sem_wait(&invitados_pueden_irse);
    for (int i = 0; i < cantidadInvitados;i++){
        levantarse('i');
    }
    exit (-1); //Si este EXIT no esta => el proceso no pasa a terminado. :( No se como hacer que termine sin necesidad de este exit().
}
```

`Hilo mozos`
```c
void *hilo_mozos(void *arg){

    sem_wait(&mozos_pueden_servir);

    while(platosServidos != comensales){
            platosServidos++;
            servirComida();
            sem_post(&empezar_a_comer);
    } 
}
```

`Funcion main`
```c
int main(){

    //Iniciar hilos
    pthread_t manucho;
    pthread_t invitados[cantidadInvitados];
    pthread_t mozos[cantidadMozos];

    //Iniciar semaforos
    //sem_init(puntero_semaforo, indica_si_es_compartido_entre_procesos, valor_inicial_semaforo)
    sem_init(&todos_invitados_sentados, 0, 1);
    sem_init(&manucho_puede_sentarse, 0, 0);
    sem_init(&mozos_pueden_servir, 0, 0);
    sem_init(&empezar_a_comer, 0, 0);
    sem_init(&hace_pregunta, 0, 0);
    sem_init(&recibe_respuesta, 0, 0);
    sem_init(&manucho_puede_irse, 0, 0);
    sem_init(&invitados_pueden_irse, 0, 0);

    //Crear hilos
    //pthread_create(puntero_al_hilo, atributos, rutina_a_ejecutar, argumentos_de_rutina);
    pthread_create(&manucho, NULL, *hilo_manucho, NULL);

    for (int i = 0; i < cantidadInvitados; i++){
        pthread_create(&invitados[i], NULL, *hilo_invitados, NULL);

    }
    for (int i = 0; i < cantidadMozos; i++){
        pthread_create(&mozos[i], NULL, *hilo_mozos, NULL);
    }

    // Bloquea el thread que hace la llamada hasta que el thread especificado como
    // atributo termina su ejecución.
    for (int i = 0; i < cantidadInvitados; i++){
        pthread_join(invitados[i], NULL);
    }
    for (int i = 0; i < cantidadMozos; i++){
        pthread_join(mozos[i], NULL);
    }

    pthread_join(manucho, NULL);

    return 0;
}
```
