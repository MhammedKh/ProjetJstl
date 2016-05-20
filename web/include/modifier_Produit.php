<?php
include("../entite/Produit.php");
$p= new Produit();


	$dat=substr($_GET['promo'],6,4).",".substr($_GET['promo'],0,2) .",".substr($_GET['promo'],3,2); 
	
	$p->modifier_produit( $_GET['id_prod'],$_GET['nom'],$_GET['des'],$_GET['prix'],$_GET['qte'],$dat,$_GET['so']);
	
	if(strlen($_GET['image1'])!=0)
		$p->modifier_image_1($_GET['id_prod'],$_GET['image1']);
	
	if(strlen($_GET['image2'])!=0)
		$p->modifier_image_2($_GET['id_prod'],$_GET['image2']);
		
	if(strlen($_GET['image3'])!=0)
		$p->modifier_image_3($_GET['id_prod'],$_GET['image3']);
		
	if(strlen($_GET['image4'])!=0)
		$p->modifier_image_4($_GET['id_prod'],$_GET['image4']);
	header("location:../edit_produit.php");

?>

