<?php
include("../entite/Commande.php");
$c= new Commande();

	$res=$c->verifier_code_Commande($_GET['code']);						
	$nbr=$res->fetch();
		
	if($nbr->count=="0")
	{
		
		$date = date("d/m/Y");
		$c->ajouter_Commande($_GET['code'],$date,$_GET['id_four']);
		header("location:../edit_ligne_commande.php?code=".$_GET['code']."&id_f=".$_GET['id_four']);
	}
	else
	{
		header("location:../edit_commande.php?verif=1");
	}


?>

