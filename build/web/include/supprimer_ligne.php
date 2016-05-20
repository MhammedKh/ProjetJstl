<?php
include("../entite/Commande.php");
include("../entite/Produit.php");
$c= new Commande();


	$c->supp_ligne_c($_GET['id_l']);
	

	$p= new Produit();
	$res_p=$p->affiche_prix_f_prod($_GET['id_prod'],$_GET['id_f']);
	$resultat_p=$res_p->fetch();
	 
	$prix=$_GET['qte']*$resultat_p->prix_f;
	echo $prix;
	$res=$c->affiche_Commande_id($_GET['code']);
	$resultat=$res->fetch();
	echo $resultat->id_c;
	
	$c->sous_prix_Commande($resultat->id_c , $prix);
	
	
	
	header("location:../edit_ligne_commande.php?code=".$_GET['code']."&id_f=".$_GET['id_f']);

?>

