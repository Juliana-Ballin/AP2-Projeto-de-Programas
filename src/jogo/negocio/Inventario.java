package jogo.negocio;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Inventario implements Serializable {
	private static final long serialVersionUID = 1114455718375165095L;
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
