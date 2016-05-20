<?php

include("../entite/Commande.php");
$c= new Commande();

if(isset($_GET['enr'])) 
{
	include("../entite/Produit.php");
	$p= new Produit();
	$res_p=$p->affiche_prix_f_prod($_GET['id_prod'],$_GET['id_four']);
	$resultat_p=$res_p->fetch();
	 
	$prix=$_GET['qte']*$resultat_p->prix_f;
	//echo $prix;
	$res=$c->affiche_Commande_id($_GET['code']);
	$resultat=$res->fetch();
	//echo $resultat;
	$c->ajouter_ligne_Commande($_GET['qte'],$_GET['id_prod'],$resultat->id_c);	
	$c->add_prix_Commande($resultat->id_c , $prix);
	header("location:../edit_ligne_commande.php?code=".$_GET['code']."&id_f=".$_GET['id_four']);
}
else
{
	
	header("location:../facture_commande.php?code=".$_GET['code']."&id_f=".$_GET['id_four']);

}



?>

