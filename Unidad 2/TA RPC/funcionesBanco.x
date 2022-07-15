
struct argumentos{
    double saldo;
    double monto;
};

program FUNCIONESBANCO{

    version Banco_Servicios{
        int Retirar (argumentos) = 1;
        int Depositar (argumentos) = 2;
    }=1;

} = 0x20000001;
