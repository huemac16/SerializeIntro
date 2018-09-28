
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class SchuelerBL extends AbstractListModel {

    private ArrayList<Schueler> schueler = new ArrayList<>();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public void add(Schueler s) {
        schueler.add(s);

        fireIntervalAdded(this, schueler.size() - 1, schueler.size() - 1);
    }

    public void save(File f) throws Exception {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.write("name,birthday");
            bw.newLine();

            for (int i = 0; i < schueler.size(); i++) {
                bw.write(schueler.get(i).getName() + "," + schueler.get(i).getBirthday().format(dtf));
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
        }
    }

    public void load(File f) throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            br.readLine();
            String s;
            while ((s = br.readLine()) != null) {
                String[] split = s.split(",");
                schueler.add(new Schueler(split[0], LocalDate.parse(split[1], dtf)));
            }
        } catch (Exception e) {
        }

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
