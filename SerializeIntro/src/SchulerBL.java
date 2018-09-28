
import java.io.File;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class SchulerBL extends AbstractListModel {

    private ArrayList<Schueler> schueler = new ArrayList<>();

    public void add(Schueler s) {
        schueler.add(s);

        fireIntervalAdded(this, schueler.size() - 1, schueler.size() - 1);
    }

    public void save(File f) throws Exception {

    }

    public void load(File f) throws Exception {

    }

    @Override
    public int getSize() {
        return schueler.size();
    }

    @Override
    public Object getElementAt(int i) {
        return schueler.get(i);
    }

}
