/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "funcionesBanco.h"
#include "ctype.h"

double saldoaux = 0;
int
funcionesbanco_1(char *host, argumentos parametros,int tipo)
{
	CLIENT *clnt;
	int  *result_1;
	argumentos  retirar_1_arg = parametros;
	int  *result_2;
	argumentos  depositar_1_arg = parametros;

#ifndef	DEBUG
	clnt = clnt_create (host, FUNCIONESBANCO, Banco_Servicios, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif
	if(tipo == 1){
		result_1 = retirar_1(&retirar_1_arg, clnt);
		if (result_1 == (int *) NULL) {
			clnt_perror (clnt, "call failed");
	}
	}else if(tipo == 2){
		result_2 = depositar_1(&depositar_1_arg, clnt);
		if (result_2 == (int *) NULL) {
			clnt_perror (clnt, "call failed");

	}
	}else if(tipo>4){
		printf("Invalido");
	}

#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG */

 if(tipo==1){
	 return *result_1;
 }else if (tipo==2){
	 return *result_2;
 }

}

void MensajesBancarios(int bnd , double saldo, double monto , int tipo){
	if(tipo == 1){
		if(bnd == 1){
			printf("Usted a retirado: %.2f $ \n", monto);
			saldoaux = (saldoaux - monto) ;
			printf("Saldo Actual:  %.2f $ \n",saldoaux);
			printf("------------------------------------------------------\n");
		}else{
			printf("Retiro incorrecto, saldo insuficiente \n");
			printf("------------------------------------------------------\n");
		}

	}else if(tipo == 2){
		if(bnd == 1){
			printf("Usted a depositado: %.2f $\n", monto);
			saldoaux = saldoaux + monto ;
			printf("Saldo Actual:  %.2f $ \n",saldoaux);
			printf("------------------------------------------------------\n");
		}else{
			printf("Deposito incorrecto \n");
			printf("------------------------------------------------------\n");
		}
	}else if (tipo == 3){
		printf("Saldo Actual:  %.2f $ \n",saldoaux);
		printf("------------------------------------------------------\n");
	}
}


int
main (int argc, char *argv[])
{
	char *host;
	int resultado = 0;
	double montoaux;

	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];

	struct argumentos {
		double saldo;
		double monto;
	};

	argumentos inputs = {1000.0,0.0};
	saldoaux = inputs.saldo;
	int tipo = 1;

	while(tipo < 4){
		printf("Seleccione lo que requiere: \n 1.Retirar \n 2.Depositar \n 3.Consultar Saldo \n 4.Salir \n");
		scanf("%d",&tipo);
		if(tipo<3){			
			printf("Ingresa el monto de dinero para realizar la transacción: \n");
			scanf("%lf",&montoaux);
			inputs.monto = montoaux;
		}

		resultado = funcionesbanco_1 (host, inputs, tipo);
		MensajesBancarios(resultado,inputs.saldo,inputs.monto,tipo);
		inputs.saldo = saldoaux;
	}
	printf("Gracias por usar el sistema\n");
	printf("------------------------------------------------------\n");
exit (0);
}
