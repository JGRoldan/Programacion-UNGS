#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <stdlib.h> 

// OUTPUT COLORS 
#define ANSI_BG_RED         "\e[41m"
#define ANSI_COLOR_GREEN    "\x1b[32m"
#define ANSI_COLOR_YELLOW   "\x1b[33m"
#define ANSI_BHI_YELLOW     "\e[1;93m"
#define ANSI_COLOR_MAGENTA  "\x1b[35m"
#define ANSI_COLOR_CYAN     "\x1b[36m"
#define ANSI_COLOR_RESET    "\x1b[0m"

//CONST ASADO
#define CANTIDAD_INVITADOS 10
#define CANTIDAD_MOZOS  5
#define COMENSALES CANTIDAD_INVITADOS+1

//Variables globales
int cantidadInvitados = CANTIDAD_INVITADOS;
int cantidadMozos = CANTIDAD_MOZOS;
int comensales = COMENSALES;
int platosServidos = 0; 
int invitadosSentados = 0;
int preguntaRespondida = 0; //false
int do_something = 0;

//Semaforos
sem_t todos_invitados_sentados;
sem_t manucho_puede_sentarse;
sem_t mozos_pueden_servir;
sem_t empezar_a_comer;
sem_t hace_pregunta;
sem_t recibe_respuesta;
sem_t manucho_puede_irse;
sem_t invitados_pueden_irse;

//Metodo para simular alguna tarea

void simularTarea(){
    for (int i = 0; i < 99999999; i++){
        do_something += i;
    }
}

//Primitivas

void sentarse(char who){
    simularTarea();
    if(who == 'i'){
        printf("Se sentó un invitado.\n");
    }
    else{
        printf( ANSI_COLOR_CYAN "Se sentó Manucho." ANSI_COLOR_RESET "\n");
    }
}

void servirComida(){
    simularTarea();
    printf(ANSI_COLOR_YELLOW "Un mozo sirvio un plato." ANSI_COLOR_RESET "\n");
}

void enojarse(){
    simularTarea();
    printf(ANSI_BG_RED "Manucho se enojo por la respuesta de un invitado." ANSI_COLOR_RESET "\n");
}

void levantarse(char who){
    //simularTarea();
    if(who == 'i'){
        printf("Se levantó un invitado. \n");
    }
    else{
        printf("Se levantó manucho. \n");
    }
}

void lanzar_pregunta_mundialista(){
    //simularTarea();
    printf("Manucho hace una pregunta mundialista. \n");
}

void lanzar_respuesta_mundialista(){
    printf("El invitado esta pensando la respuesta... \n");
    simularTarea();
    printf("El invitado respondio. \n");
}


//Hilos

void *hilo_manucho(void *arg){

    sem_wait(&manucho_puede_sentarse);
    sentarse('m');

    for (int i=0; i<comensales;i++){
        sem_post(&mozos_pueden_servir);
    }

    sem_wait(&empezar_a_comer);
    printf(ANSI_COLOR_GREEN "MANUCHO esta comiendo" ANSI_COLOR_RESET "\n");
    simularTarea();
    printf(ANSI_COLOR_CYAN "MANUCHO termino de comer" ANSI_COLOR_RESET "\n");

    lanzar_pregunta_mundialista();
    sem_post(&hace_pregunta);
    sem_wait(&recibe_respuesta);
    enojarse();
    sem_wait(&manucho_puede_irse);
    levantarse('m');
    sem_post(&invitados_pueden_irse);
}

void *hilo_invitados(void *arg){

    sem_wait(&todos_invitados_sentados);
    sentarse('i');
    invitadosSentados++;
    
    if(invitadosSentados == cantidadInvitados ){
        sem_post(&manucho_puede_sentarse);
    }

    sem_post(&todos_invitados_sentados);

    sem_wait(&empezar_a_comer);
    printf(ANSI_COLOR_GREEN "Un INVITADO esta comiendo" ANSI_COLOR_RESET "\n");
    simularTarea();
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

void *hilo_mozos(void *arg){

    sem_wait(&mozos_pueden_servir);

    while(platosServidos != comensales){
            platosServidos++;
            servirComida();
            sem_post(&empezar_a_comer);
    }
    
}

int main(){

    //Iniciar hilos
    pthread_t manucho, invitados[cantidadInvitados], mozos[cantidadMozos];

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

    sem_destroy(&todos_invitados_sentados);
    sem_destroy(&manucho_puede_sentarse);
    sem_destroy(&mozos_pueden_servir);
    sem_destroy(&empezar_a_comer);
    sem_destroy(&hace_pregunta);
    sem_destroy(&recibe_respuesta);
    sem_destroy(&manucho_puede_irse);
    sem_destroy(&invitados_pueden_irse);
    
    return 0;
}


