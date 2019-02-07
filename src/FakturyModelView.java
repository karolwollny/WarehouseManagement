import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class FakturyModelView implements TableModel {

    String numer, imie, firma, adres, data, przyjecie, nazwa, ilosc, cena_za_sztuke, cena_netto, cena_brutto, vat, komentarze;

    public FakturyModelView(String numer, String imie, String firma, String adres, String data, String przyjecie, String nazwa, String ilosc, String cena_za_sztuke, String cena_netto, String cena_brutto, String vat, String komentarze) {
        this.numer = numer;
        this.imie = imie;
        this.firma = firma;
        this.adres = adres;
        this.data = data;
        this.przyjecie = przyjecie;
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.cena_za_sztuke = cena_za_sztuke;
        this.cena_netto = cena_netto;
        this.cena_brutto = cena_brutto;
        this.vat = vat;
        this.komentarze = komentarze;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPrzyjecie() {
        return przyjecie;
    }

    public void setPrzyjecie(String przyjecie) {
        this.przyjecie = przyjecie;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getIlosc() {
        return ilosc;
    }

    public void setIlosc(String ilosc) {
        this.ilosc = ilosc;
    }

    public String getCena_za_sztuke() {
        return cena_za_sztuke;
    }

    public void setCena_za_sztuke(String cena_za_sztuke) {
        this.cena_za_sztuke = cena_za_sztuke;
    }

    public String getCena_netto() {
        return cena_netto;
    }

    public void setCena_netto(String cena_netto) {
        this.cena_netto = cena_netto;
    }

    public String getCena_brutto() {
        return cena_brutto;
    }

    public void setCena_brutto(String cena_brutto) {
        this.cena_brutto = cena_brutto;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getKomentarze() {
        return komentarze;
    }

    public void setKomentarze(String komentarze) {
        this.komentarze = komentarze;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
