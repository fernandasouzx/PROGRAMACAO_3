// Interface para quem corre
interface Corredor {
    void correr();
}

interface Nadador {
    void nadar();
}

interface Ciclista {
    void pedalar();
}

class Triatleta_ implements Corredor, Nadador, Ciclista {
    private String nome;

    public Triatleta_(String nome) {
        this.nome = nome;
    }

    @Override
    public void correr() {
        System.out.println(nome + " está correndo!");
    }

    @Override
    public void nadar() {
        System.out.println(nome + " está nadando!");
    }

    @Override
    public void pedalar() {
        System.out.println(nome + " está pedalando!");
    }
}

// 👉 Aqui o nome da classe pública tem que bater com o nome do arquivo!
public class Triatleta {
    public static void main(String[] args) {
        Triatleta_ t = new Triatleta_("Fernanda");
        t.correr();
        t.nadar();
        t.pedalar();
    }
}
