package poutine;

import java.util.ArrayList;



public class Facture {

	private ArrayList<String> listeClients;
	private ArrayList<String> listePlats;
	private ArrayList<String> listeCommandes;
	
	//Constructeur
	public Facture(){
		this.listeClients = new ArrayList<String>();
		this.listePlats = new ArrayList<String>();
		this.listeCommandes = new ArrayList<String>();	
	}
	
	public void affichageListe(){

		System.out.println("Les Clients\n");
		
		for ( String string : this.listeClients ) {
			System.out.println( string );
		}
		
		System.out.println("Les Plats\n");

		for ( String string : this.listePlats ) {
			System.out.println( string );
		}

		System.out.println("Les Commandes\n");

		for ( String string : this.listeCommandes ) {
			System.out.println( string );
		}
	}


	
	public void addListeClients( String string ) {
		this.listeClients.add( string );

	}

	public void addListePlats( String string ) {
		this.listePlats.add( string );
	}

	public void addListeCommandes( String string ) {
		this.listeCommandes.add( string );
	}

}