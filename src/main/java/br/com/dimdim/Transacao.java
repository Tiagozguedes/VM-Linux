package br.com.dimdim;
public class Transacao {
    private String tipo;
    private double valor;
    private String descricao;
    public Transacao(String tipo, double valor, String descricao) {
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
    }
    public String getTipo() { return tipo; }
    public double getValor() { return valor; }
    public String getDescricao() { return descricao; }
}
