package menu;

import salad.Salad;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SaladMenu {

    private static final SaladMenu instance = new SaladMenu();
    private List<Salad> menu = new ArrayList<>();

    private SaladMenu() {
    }

    public static SaladMenu getInstance() {
        return instance;
    }

    public List<Salad> getSalads() {
        return this.menu;
    }

    public void addSalad(Salad salad) {
        this.menu.add(salad);
    }

    public void addSalad(List<Salad> salads) {
        for(Salad salad : salads) {
            this.menu.add(salad);
        }
    }

    public void delSalad(Salad salad) {
        this.menu.remove(salad);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaladMenu saladMenu = (SaladMenu) o;
        return Objects.equals(menu, saladMenu.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }
}
