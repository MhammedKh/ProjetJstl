<?php
include("../entite/Produit.php");
$p= new Produit();

/*echo $_GET['id_prod'];
echo "<br> ";
echo $_GET['id_four'];*/
	
	$p->modifier_prix_f_prod( $_GET['id_prod'],$_GET['id_four'],$_GET['prix']);
	
	
		header("location:../affiche_prod_four.php?id_f=".$_GET['id_four']);

?>

