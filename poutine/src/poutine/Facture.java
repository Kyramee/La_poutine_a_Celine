package poutine;

import java.io.BufferedReader;
import java.nio.file.*;
import java.util.ArrayList;



public class Facture {

	private ArrayList<String> listeClients = new ArrayList<String>();
	private ArrayList<String> listePlats = new ArrayList<String>();
	private ArrayList<String> listeCommandes = new ArrayList<String>();
	private ArrayList<String> listeFacture = new ArrayList<String>();
	
	private String[] tabClients;
	private String[] tabPlats;
	private String[] tabCommandes;
	//Constructeur
	public Facture(){
		
	}
	
public Facture(String[] tabClients, String[] tabPlats, String[] tabCommandes){
	this.tabClients = tabClients;
	this.tabPlats = tabPlats;
	this.tabCommandes = tabCommandes;
		
	}

	public void addClientTab( int index, String ligne ) {
		this.tabClients[index] = ligne;
	}

	public void addPlatTab( int index, String ligne ) {
		this.tabPlats[index] = ligne;
	}

	public void addCommandeTab( int index, String ligne ) {
		this.tabCommandes[index] = ligne;
	}
	
	public void affichageTab(){
		System.out.println("");
		System.out.println("Les Clients");
		System.out.println("");
		for ( String string : this.tabClients ) {
			System.out.println( string );
		}
		System.out.println("");
		System.out.println("Les Plats");
		System.out.println("");
		for ( String string : this.tabPlats ) {
			System.out.println( string );
		}
		System.out.println("");
		System.out.println("Les Commandes");
		System.out.println("");
		for ( String string : this.tabCommandes ) {
			System.out.println( string );
		}
	}
	
	public void affichageListe(){
		System.out.println("");
		System.out.println("Les Clients");
		System.out.println("");
		for ( String string : this.listeClients ) {
			System.out.println( string );
		}
		System.out.println("");
		System.out.println("Les Plats");
		System.out.println("");
		for ( String string : this.listePlats ) {
			System.out.println( string );
		}
		System.out.println("");
		System.out.println("Les Commandes");
		System.out.println("");
		for ( String string : this.listeCommandes ) {
			System.out.println( string );
		}
	}

	public void calculFacture() {
		for ( int i = 0; i < listeFacture.size() -1; i++ ) {
			String[] data = listeFacture.get( i ).split( " " );
			String[] data2 = listeFacture.get( i+1 ).split( " " );
			
			if ( data[0].equals( data2[0] ) ) {
				System.out.println( data[0] + " " + (Double.parseDouble( data[1] ) +Double.parseDouble( data2[1] )) );
			} else {
				System.out.println( listeFacture.get( i ) );
			}
		}
		
	}

	public void commandeParClient() {
		String message;
		for ( String client : listeClients ) {
			System.out.println(  );
			System.out.println( "Voici les commandes de " + client );
			for ( String commande : listeCommandes ) {
				if(commande.contains( client )){
					System.out.println(commande);
					String[] tabCommandes = commande.split( " " );

					for ( String plats : listePlats ) {
						String[] tabPlats = plats.split( " " );
						if ( tabCommandes[1].contains( tabPlats[0] ) ) {
							message = client + " " + Double.parseDouble( tabCommandes[2] ) * Double.parseDouble( tabPlats[1] );
							listeFacture.add( message );
						}
					}
					
				}
			}
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