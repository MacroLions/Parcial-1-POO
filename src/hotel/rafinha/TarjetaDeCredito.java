/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.rafinha;

/**
 *
 * @author Nuria
 */
public class TarjetaDeCredito {
    private String titular;
    private String bancoAfiliado;
    private String tipoDeCuenta;

    public TarjetaDeCredito() {
    }

    public TarjetaDeCredito(String titular, String bancoAfiliado, String tipoDeCuenta) {
        this.titular = titular;
        this.bancoAfiliado = bancoAfiliado;
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getBancoAfiliado() {
        return bancoAfiliado;
    }

    public void setBancoAfiliado(String bancoAfiliado) {
        this.bancoAfiliado = bancoAfiliado;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public int[] getCodigo() {
        return codigo;
    }

    public void setCodigo(int[] codigo) {
        this.codigo = codigo;
    }
    
    int [] codigo= new int[8]; //Arreglo para el codigo de la tarjeta
    
}
