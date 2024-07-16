package jogo.negocio;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Item> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) throws Exception {
        if (itens.contains(item)) {
            throw new Exception("Item duplicado não pode ser adicionado ao inventário.");
        }
        itens.add(item);
    }

    public List<Item> getItens() {
        return itens;
    }
}
