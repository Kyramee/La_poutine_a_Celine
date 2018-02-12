package poutine;

import java.util.ArrayList;

public class Facture {

	private ArrayList<String> listeClients;
	private ArrayList<String> listeNomPlats;
	private ArrayList<String> listePrixPlats;
	private ArrayList<String> listeCommandes;

	// Constructeur
	public Facture() {
		this.listeClients = new ArrayList<>();
		this.listeNomPlats = new ArrayList<>();
		this.listePrixPlats = new ArrayList<>();
		this.listeCommandes = new ArrayList<>();
	}

	public void addListeClients(String client) {
		this.listeClients.add(client);

	}

	public void addListePlats(String plat) {
		String[] platSplit = plat.split(" ");
		this.listeNomPlats.add(platSplit[0]);
		this.listePrixPlats.add(platSplit[1]);
	}

	public void addListeCommandes(String commande) {
		this.listeCommandes.add(commande);
	}

	public void affichageFacture() {
		String[] comSplit;
		double[] facture = new double[this.listeClients.size()];

		for (double d : facture) {
			d = 0.0;
		}

		System.out.println("Bienvenue chez Barette!\nFactures:");

		for (String commande : this.listeCommandes) {
			comSplit = commande.split(" ");

			if (comSplit.length != 3) {
				System.out.println("Format de commande invalide");
			} else if (!this.listeClients.contains(comSplit[0])) {
				System.out.println("Le nom du client n'est pas dans la liste");
			} else if (!this.listeNomPlats.contains(comSplit[1])) {
				System.out.println("Le nom du plat n'est pas dans la liste");
			} else {

				facture[this.listeClients.indexOf(comSplit[0])] += Double
						.parseDouble(this.listePrixPlats.get(this.listeNomPlats.indexOf(comSplit[1])))
						* Double.parseDouble(comSplit[2]);
			}
		}
	}
}
