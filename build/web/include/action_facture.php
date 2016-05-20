<?php

									include("../entite/commande.php");
									$c= new commande();
										$res=$c->affiche_Commande_id($_GET['code']);
							
										$resultat=$res->fetch();
										
							
										
$messsage='<html>
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>

	</head>
<body>
<h2><b><u><div> <center>Demande d achat</center></div></u></b></h2> 
<table style ="margin-top:60px;
	margin-left:60%;
	margin-bottom:60px;" border="0"  >
				<tr>
				<td><h3>Date :</h3></td>
				<td style ="padding-left:20px;"><h3>'.strip_tags( $resultat->date ) .'</h3></td>
				</tr>
					<tr>
				<td><h3>Client :</h3></td>
				<td style ="padding-left:20px;"><h3> xxxxxxxx xxxx </h3></td>
				</tr>
					<tr>
				<td><h3>Téléphone :</h3></td>
				<td style ="padding-left:20px;"><h3>(xxx)xx xx xx</h3></td>
				</tr>
					<tr>
				<td><h3>Email :</h3></td>
				<td style ="padding-left:20px;"">mhammed.kharrat1@gmail.com</h3></td>
				</tr>
				<td><h3>Adresse :</h3></td>
				<td style ="padding-left:20px;"><h3> Route x km x  </h3></td>
				</tr>
				</table>
				<center>
<table >
							  <thead>
								  <tr  >
									  <th style="    padding: 8px;
												padding-top: 8px;
												padding-right: 8px;
												padding-bottom: 8px;
												padding-left: 8px;
												line-height: 20px;
												text-align: left;
												vertical-align: top;
												border-top: 1px solid #eee; border-bottom : 1px solid #eee; " width=15% ><center>Nom </center> </th>
									  <th style="    padding: 8px;
												padding-top: 8px;
												padding-right: 8px;
												padding-bottom: 8px;
												padding-left: 8px;
												line-height: 20px;
												text-align: left;
												vertical-align: top;
												border-top: 1px solid #eee; border-bottom : 1px solid #eee;  " width=15%><center>Quantité</center></th>
									  <th style="    padding: 8px;
												padding-top: 8px;
												padding-right: 8px;
												padding-bottom: 8px;
												padding-left: 8px;
												line-height: 20px;
												text-align: left;
												vertical-align: top;
												border-top: 1px solid #eee; border-bottom : 1px solid #eee;  " width=15%><center>Prix Unitaire</center></th>
									  <th style="    padding: 8px;
												padding-top: 8px;
												padding-right: 8px;
												padding-bottom: 8px;
												padding-left: 8px;
												line-height: 20px;
												text-align: left;
												vertical-align: top;
												border-top: 1px solid #eee; border-bottom : 1px solid #eee; "  width=15%><center>Prix Net</center></th>                                          
								  </tr>
							  </thead>   
							  <tbody>';
						
								
								
								
										$res_l=$c->affiche_ligne_commande_fct($_GET['code'],$_GET['id_f']);
							
									while($resultat_l=$res_l->fetch())
									{
										$c->ajouter_qte_p_c($resultat_l->id_p,$resultat_l->qte_l);
									$messsage = $messsage .'<tr>
									<td style="    padding: 8px;
												padding-top: 8px;
												padding-right: 8px;
												padding-bottom: 8px;
												padding-left: 8px;
												line-height: 20px;
												text-align: left;
												vertical-align: top;
												border-top: 1px solid #eee; border-bottom : 1px solid #eee; "><center>'. strip_tags( $resultat_l->nom ) . '</center></td>
									<td style="    padding: 8px;
												padding-top: 8px;
												padding-right: 8px;
												padding-bottom: 8px;
												padding-left: 8px;
												line-height: 20px;
												text-align: left;
												vertical-align: top;
												border-top: 1px solid #eee; border-bottom : 1px solid #eee; "><center>'.strip_tags( $resultat_l->qte_l).'</center> </td>
									<td style="    padding: 8px;
												padding-top: 8px;
												padding-right: 8px;
												padding-bottom: 8px;
												padding-left: 8px;
												line-height: 20px;
												text-align: left;
												vertical-align: top;
												border-top: 1px solid #eee; border-bottom : 1px solid #eee; " ><center>'.strip_tags($resultat_l->prix_f ) .'DT</center></td>
									<td style="    padding: 8px;
												padding-top: 8px;
												padding-right: 8px;
												padding-bottom: 8px;
												padding-left: 8px;
												line-height: 20px;
												text-align: left;
												vertical-align: top;
												border-top: 1px solid #eee; border-bottom : 1px solid #eee; "><center>'.strip_tags( $resultat_l->prix_f*$resultat_l->qte_l) .' DT</center></td>                                     
								</tr>';
								}
										
										
								
								$messsage=$messsage.'
								                               
							  </tbody>
						 </table>
</center>	
<table style ="margin-top:60px;
	margin-left:60%;
	margin-bottom:60px;" border="0"  >
				<tr>
				
				<td><h3>Total facture :</h3></td>
				<td style ="padding-left:20px;"><h3>'.strip_tags( $resultat->prix_tot ).' DT</h3></td>
				</tr>
				</table>							 
						 </body>
						 </html>';
$headers  = 'MIME-Version: 1.0' . "\r\n";
     $headers .= 'Content-type: text/html; charset=utf8_decode' . "\r\n";
mail ("mhammed.kharrat1@gmail.com" , "sujet", $messsage ,$headers ) ;
$c->commande_acheter($_GET['code']);
header("location:../edit_commande.php");
?>

