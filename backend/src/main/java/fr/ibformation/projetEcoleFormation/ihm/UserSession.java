package fr.ibformation.projetEcoleFormation.ihm;

import fr.ibformation.projetEcoleFormation.bo.Utilisateur;

public class UserSession {
    private Utilisateur utilisateur;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserSession{");
        sb.append("utilisateur=").append(utilisateur);
        sb.append('}');
        return sb.toString();
    }
}
