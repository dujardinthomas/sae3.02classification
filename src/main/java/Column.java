/**
 * Decrit une <i>colonne</i> d'un DataSet.
 *
 * Une colonne a un nom, son DataSet parent et un normaliseur optionnel.
 *
 * Un normaliseur traduit toutes les valeurs possibles de la colonne
 * (dans son DataSet) en une valeur entre 0 et 1.
 * Seule les colonnes <i>normalisables</i> (qui ont un normaliseur) peuvent
 * etre utilisees comme axe dans le nuage de points.
 */
public interface Column<T extends Point> {

    /**
     * Recupere la valeur de cette colonne dans la donnee en parametre,
     * puis normalise cette valeur )entre 0 et 1) et la retourne normalisee.
     * Si la colonne n'est pas normalisable, le comportement n'est pas
     * definit.
     */

    double getNormalizedValue(T point);

    /**
     * "Denormalise" une valeur entre 0 et 1 en une "vraie" valeur pour
     * cette colonne.
     * Si la colonne n'est pas normalisable, le comportement n'est pas
     * definit.
     */

    Object getDenormalizedValue(double value);

    /**
     * Retourne le nom de la colonne.
     */
    public String getName();
    /**
     * Retourne le DataSet auquel cette colonne appartient.
     */

    DataSet<T> getDataset();
    /**
     * Indique si cette colonne est normalisable (a un <i>normaliseur</i>).
     */
    boolean isNormalizable();
}
