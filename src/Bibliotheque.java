public class Bibliotheque {
    public static Livre[] bib = new Livre[25];
    public static int nbLivresPresents;
    //ajouter livre
    public static void ajoutLivre(Livre l) {
        if (l != null) {
            Bibliotheque.bib[nbLivresPresents] = l;
            Bibliotheque.nbLivresPresents++;
        }
    }
    //afficher livre
    public static String inString() {
        final StringBuffer sb = new StringBuffer("Bibliotheque{");
        for (int i = 0; i < nbLivresPresents; i++) {
            sb.append(bib[i].toString() + "/n");
        }
        sb.append('}');
        return sb.toString();
    }
    public static void triLivre() {
        int choix;
        do {
            System.out.println("Veuillez choisir le type de tri à effectuer : " + "1. par Titre, " + "2. par Auteur, " + "3. par Editeur");
            choix = Util.scan.nextInt();
        } while (choix < 1 || choix > 3);
        switch(choix){
            case 1:

                ;
            case 2:
                ;
            case 3:
                ;
            default:
                System.out.println("Choix invalide.");
                break;

        }
    }
    public Livre chercherLivreParTitre(String titre) {
        for (int i = 0; i < nbLivresPresents; i++) {
            if (bib[i].getTitre().equalsIgnoreCase(titre)) {
                return bib[i];
            }
        }
        return null; // Livre non trouvé
    }
    public Livre chercherLivreParAuteur(String titre) {
        for (int i = 0; i <  nbLivresPresents; i++) {
            if (bib[i].getAuteur().equalsIgnoreCase(titre)) {
                return bib[i];
            }
        }
        return null;
    }
    public Livre chercherLivreParEditeur(String titre) {
        for (int i = 0; i < nbLivresPresents; i++) {
            if (bib[i].getEditeur().equalsIgnoreCase(titre)) {
                return bib[i];
            }
        }
        return null;
    }
    public boolean supprimerLivreParTitre(String titre) {
        for (int i = 0; i < nbLivresPresents; i++) {
            if (bib[i].getTitre().equalsIgnoreCase(titre)) {
                // Demander confirmation avant de supprimer
                System.out.println("Êtes-vous sûr de vouloir supprimer ce livre ? (Appuyez sur Enter pour confirmer)");
                String confirmation = Util.scan.nextLine();
                if (confirmation.isEmpty()) {
                    // Confirmation de la suppression
                    // On décale les livres d'après pour remplir l'espace
                    for (int j = i; j < nbLivresPresents - 1; j++) {
                        bib[j] = bib[j + 1];
                    }
                    bib[nbLivresPresents - 1] = null;
                    nbLivresPresents--;
                    return true; // Le livre est supprimé
                } else {
                    System.out.println("Suppression annulée.");
                    return false; // Suppression annulée
                }
            }
        }
        return false; // Livre non trouvé, pas de suppression
    }
    public boolean modifierLivreParTitre(String titre) {
        Livre livreAModifier = chercherLivreParTitre(titre);
        if (livreAModifier != null) {
            System.out.println("Entrez le nouveau titre :");
            String nouveauTitre = Util.scan.nextLine();
            System.out.println("Entrez le nouvel auteur :");
            String nouveauAuteur = Util.scan.nextLine();
            System.out.println("Entrez le nouvel éditeur :");
            String nouvelEditeur = Util.scan.nextLine();

            // Mettre à jour les informations du livre
            livreAModifier.setTitre(nouveauTitre);
            livreAModifier.setAuteur(nouveauAuteur);
            livreAModifier.setEditeur(nouvelEditeur);

            System.out.println("Le livre a bien été modifié.");
            return true;
        } else {
            System.out.println("Livre non trouvé. Aucune modification.");
            return false;
        }
    }



}


