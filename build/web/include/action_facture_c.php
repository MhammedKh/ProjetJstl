<?php

									include("../entite/commande.php");
									$c= new commande();
										$c->change_Commande_c($_GET['code']);
				
header("location:../Affiche_commande_C.php");
?>

