public enum MoedaEnum {
    ARS("Peso argentino", "ARS", "ARS $"),
    BOB("Boliviano boliviano", "BOB", "BOB $"),
    BRL("Real brasileiro", "BRL", "R$"),
    CLP("Peso chileno", "CLP", "CLP $"),
    COP("Peso colombiano", "COP", "COP $"),
    USD("Dólar americano", "USD", "US$");

    private final String nome;
    private final String codigo;
    private final String simbolo;

    MoedaEnum(String nome, String codigo, String simbolo) {
        this.nome = nome;
        this.codigo = codigo;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
