package poutine;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainTest {
	

	public static void main( String[] args ) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader ficLecture = null;
		Path chemin = null;
		Facture facture;
		
		try {
			chemin = Paths.get( "commande.txt" );
		} catch ( InvalidPathException errNomFichier ) {
			System.out.print( errNomFichier );

		}
		
		try {
			ficLecture = Files.newBufferedReader( chemin, Charset.defaultCharset() );
		} catch ( IOException err) {
			System.out.print( err );

		}
		
		String[] tabClients = new String[3];
		String[] tabPlats = new String[3];
		String[] tabCommandes = new String[3];
		
		facture = new Facture(tabClients, tabPlats, tabCommandes);
		
		ecriture(ficLecture, facture);
		
		facture.affichageTab();

		
	}
	
	public static void ecriture(BufferedReader ficLecture, Facture facture) throws IOException{
		String ligne;
		Boolean client = false, plat = false, commande = false;
		int cptClient = 0, cptPlat = 0, cptCommande = 0;

		while ( (ligne = ficLecture.readLine() ) != null ) {
			
			
			if ( ligne.contains( "Clients" ) ) {
				client = true;
				plat = false;
				commande = false;
			} else if (ligne.contains( "Plats" )) {
				client = false;
				plat = true;
				commande = false;
			} else if (ligne.contains( "Commandes" )) {
				client = false;
				plat = false;
				commande = true;
			} else if (ligne.contains( "Fin" )) {
				break;
			}
			
			if(client && !ligne.contains( "Clients" )) {
				//facture.addListeClients( ligne );
				facture.addClientTab( cptClient, ligne );
				cptClient++;
			} else if(plat && !ligne.contains( "Plats" )){
				//facture.addListePlats( ligne );
				facture.addPlatTab( cptPlat, ligne );
				cptPlat++;
			} else if(commande && !ligne.contains( "Commandes" )){
				//facture.addListeCommandes( ligne );
				facture.addCommandeTab( cptCommande, ligne );
				cptCommande++;
			}
			
		}
		
	}

}
