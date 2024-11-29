package utils

import model.BulletinDeNotes
import model.Matiere

class FonctionsUtilitaires {


    fun calculerMoyenneParMatiere(bulletins: List<BulletinDeNotes>): Map<Matiere, Float> {
        return bulletins.flatMap { it.notes.entries }  //Après flatMap : on obtient [("Maths", 14f), ("Physique", 16f), ("Maths", 12f), ("Chimie", 15f)] par exemple
            .groupBy { it.key }
            .mapValues { it.value.map { pair -> pair.value }.average().toFloat() }
    }


    fun matieresAvecMoyenneSuperieureA12(bulletins: List<BulletinDeNotes>): List<Matiere> {
        return calculerMoyenneParMatiere(bulletins)
            .filter { it.value > 12 }
            .map { it.key }
    }


    fun etudiantsAvecMoyenneSuperieureA10(bulletins: List<BulletinDeNotes>): List<String> {
        return bulletins.filter { it.moyenneGenerale >= 10 }
            .map { "${it.etudiant.nom} ${it.etudiant.prenom}" }
    }


    fun trierEtudiantsParMoyenne(bulletins: List<BulletinDeNotes>): List<String> {
        return bulletins.sortedByDescending { it.moyenneGenerale }
            .map { "${it.etudiant.nom} ${it.etudiant.prenom}" }
    }

}