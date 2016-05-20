<?php 
include("../entite/Session.php");
if(isset($_POST['verif']))
{

	if($_POST['username']=="admin" && $_POST['password']=="admin")
	{
		$s=new Session();
		$s->inputSession("id","1");
		var_dump($_SESSION['id']);
		header("location:../edit_commande.php");
	
	}
	else
	{
		if($_POST['username']!="admin")
		header("location:../login.php?e=login&log=".$_POST['username']);
			
		else
			header("location:../login.php?e=pwd&log=".$_POST['username']);
			
	}
}
?>