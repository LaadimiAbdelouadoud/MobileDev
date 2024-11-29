package main

import model.*
import java.util.HashMap


fun afficherToutesLesMatieres() {
  val matieres= Matiere.values()
  for (m in matieres){
      m.afficherInfos()
  }
}
val lambda1={matiere: Matiere -> matiere.afficherInfos() }

fun afficherToutesLesMatieresV2(){
    val matieres= Matiere.values()
    for (m in matieres){
        lambda1(m)
    }
}

val lambda2={it : Matiere -> it.afficherInfos() }

fun afficherToutesLesMatieresV3(){
    val matieres= Matiere.values()
    matieres.map(lambda2)
}

fun main(){

    /*Enseignants*/


    //afficherToutesLesMatieres()
    val enseignant1= Enseignant("MAHDIOUI",  "LAADIMI",  20,  "mahdioui.laadimi@gmail.com", "Topologie", 20F)
    val enseignant2= Enseignant("ABDELOUADOUD",  "SALMA",  18,  null, "Histoire", 10F)


    //assignation des nouvelles matieres à l'enseignant1
    enseignant1.ajouterMatiere(Matiere.RÉSEAUX)
    enseignant1.ajouterMatiere(Matiere.ALGORITHMIQUE)

    //enseignant1.afficherInfos()
    //enseignant2.afficherInfos()

    enseignant1.afficherMatieres()
    enseignant2.afficherMatieres()





    /*Etudiants*/



    val etudiant1=Etudiant("fati", "jamali", 18, "fati.safae@gmail.com", null , Semestre.S2)

    val notes1= hashMapOf(Matiere.RÉSEAUX to 20F, Matiere.BIG_DATA to 17F)
    val etudiant2=Etudiant("safae", "fati", 18, "fati.safae@gmail.com", notes1 , Semestre.S2)

    val notes2= hashMapOf(Matiere.RÉSEAUX to 2F, Matiere.BIG_DATA to 19F)
    val etudiant3=Etudiant("mehdi", "otmane", 19, "otmane.mehdzi@gmail.com",  notes2 , Semestre.S2)

    //etudiant1.definierMatierePreferee(Matiere.RÉSEAUX)
    //etudiant2.definierMatierePreferee(Matiere.CLOUD_COMPUTING)

    //etudiant1.afficherInfos()
    //etudiant2.afficherInfos()



    /*Bulletin*/

    val bulletin1 = BulletinDeNotes(etudiant2, notes1, Semestre.S2)
    val bulletin2 = bulletin1.copy(semestre = Semestre.S3)

    println(bulletin1.toString())
    //println(bulletin2.toString())
}