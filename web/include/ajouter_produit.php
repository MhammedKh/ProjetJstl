<?php
include("../entite/Produit.php");
$p= new Produit();



	$p->ajouter_Produit($_GET['nom'],$_GET['des'],$_GET['prix'],$_GET['image1'],$_GET['image2'],$_GET['image3'],$_GET['image4']);
	$image1 = "C:/Users/makni/Desktop/image/".$_GET['image1'];
	$image2 = "C:/Users/makni/Desktop/image/".$_GET['image2'];
	$image3 = "C:/Users/makni/Desktop/image/".$_GET['image3'];
	$image4 = "C:/Users/makni/Desktop/image/".$_GET['image4'];
	$n_image1 = "C:/PROGRA~2\EASYPH~1.1VC/data/localweb/projects/e_commerce/image/".$_GET['image1'];
	$n_image2 = "C:/PROGRA~2\EASYPH~1.1VC/data/localweb/projects/e_commerce/image/".$_GET['image2'];
	$n_image3 = "C:/PROGRA~2\EASYPH~1.1VC/data/localweb/projects/e_commerce/image/".$_GET['image3'];
	$n_image4 = "C:/PROGRA~2\EASYPH~1.1VC/data/localweb/projects/e_commerce/image/".$_GET['image4'];
	
$b=copy($image1, $n_image1) ;

 
copy($image2, $n_image2) ;
copy($image3, $n_image3) ;
copy($image4, $n_image4)  ; 

	header("location:../edit_produit.php");

?>

