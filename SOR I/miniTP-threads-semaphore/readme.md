_Primitivas_
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

