#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

pthread_mutex_t mutex;
long suma = 0;
long *factorial(int num)
{
    long *r = (long*)malloc(1*sizeof(long));
    long i = 1;
    long f=1;
    while(i<=num){
        f = f*i;
        i = i+1;
    }
    r[0]=f;
    printf("El factorial de %i es : %ld \n",num,f);
    pthread_mutex_lock(&mutex);
	suma = suma + f;
	pthread_mutex_unlock(&mutex);
    return NULL;
}

void *factorial_(void *args){
    long num = *((long*)args);
    return (void*)factorial(num);

}


int main(int argc, char **argv){
    long num3=3;
    long num4=4;
    long num5=5;
    long num6=6;
    long num7=7;
    long num8 = 8;
    long num9 = 9;
    long num10 = 10;
    int hilos = 8;
    pthread_t thread[hilos];

    
    pthread_create(&thread[0],NULL,factorial_,&num3);
    pthread_create(&thread[1],NULL,factorial_,&num4);
    pthread_create(&thread[2],NULL,factorial_,&num5);
    pthread_create(&thread[3],NULL,factorial_,&num6);
    pthread_create(&thread[4],NULL,factorial_,&num7);
    pthread_create(&thread[5],NULL,factorial_,&num8);
    pthread_create(&thread[6],NULL,factorial_,&num9);
    pthread_create(&thread[7],NULL,factorial_,&num10);
    
    for (size_t i = 0; i < 8; i++)
    {
        pthread_join(thread[i],NULL);
    }
   
    printf("Suma: %ld \n", suma);

    return 0;
}