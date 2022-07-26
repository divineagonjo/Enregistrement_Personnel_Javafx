/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author USER
 */
public class Fiche {
     private String id;
    private String numCarte;
     private String nom;
      private String postnom;
       private String prenom;
        private String sexe;
         private String dateNaissance;
          private String provinceOrigine;
           private String lieuNaissance;
            private String adresse;
             private String email;
              private String numTelephone;
               private String diplome;
                private String etatCivil;

    public Fiche() {
    }

    public Fiche(String id, String numCarte, String nom, String postnom, String prenom, String sexe, String dateNaissance, String provinceOrigine, String lieuNaissance, String adresse, String email, String numTelephone, String diplome, String etatCivil) {
        this.id = id;
        this.numCarte = numCarte;
        this.nom = nom;
        this.postnom = postnom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.provinceOrigine = provinceOrigine;
        this.lieuNaissance = lieuNaissance;
        this.adresse = adresse;
        this.email = email;
        this.numTelephone = numTelephone;
        this.diplome = diplome;
        this.etatCivil = etatCivil;
    }
    
      public Fiche(String numCarte, String nom, String postnom, String prenom, String sexe, String dateNaissance, String provinceOrigine, String lieuNaissance, String adresse, String email, String numTelephone, String diplome, String etatCivil) {
        this.numCarte = numCarte;
        this.nom = nom;
        this.postnom = postnom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.provinceOrigine = provinceOrigine;
        this.lieuNaissance = lieuNaissance;
        this.adresse = adresse;
        this.email = email;
        this.numTelephone = numTelephone;
        this.diplome = diplome;
        this.etatCivil = etatCivil;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the numCarte
     */
    public String getNumCarte() {
        return numCarte;
    }

    /**
     * @param numCarte the numCarte to set
     */
    public void setNumCarte(String numCarte) {
        this.numCarte = numCarte;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the postnom
     */
    public String getPostnom() {
        return postnom;
    }

    /**
     * @param postnom the postnom to set
     */
    public void setPostnom(String postnom) {
        this.postnom = postnom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the sexe
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    /**
     * @return the dateNaissance
     */
    public String getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * @return the provinceOrigine
     */
    public String getProvinceOrigine() {
        return provinceOrigine;
    }

    /**
     * @param provinceOrigine the provinceOrigine to set
     */
    public void setProvinceOrigine(String provinceOrigine) {
        this.provinceOrigine = provinceOrigine;
    }

    /**
     * @return the lieuNaissance
     */
    public String getLieuNaissance() {
        return lieuNaissance;
    }

    /**
     * @param lieuNaissance the lieuNaissance to set
     */
    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the numTelephone
     */
    public String getNumTelephone() {
        return numTelephone;
    }

    /**
     * @param numTelephone the numTelephone to set
     */
    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    /**
     * @return the diplome
     */
    public String getDiplome() {
        return diplome;
    }

    /**
     * @param diplome the diplome to set
     */
    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    /**
     * @return the etatCivil
     */
    public String getEtatCivil() {
        return etatCivil;
    }

    /**
     * @param etatCivil the etatCivil to set
     */
    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }
                
}
