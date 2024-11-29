package model

import java.time.LocalDate

data class BulletinDeNotes(val etudiant: Etudiant,  val notes: HashMap<Matiere, Float>, val semestre: Semestre) {

    val moyenneGenerale : Float by lazy {
        println("Calcul de la moyenne generale...")
        calculerMoyenneGenerale()
    }

    val mention : String by lazy {
        println("Calcul de la moyenne generale...")
        deduireMention()
    }

    // Methode pour calculer la moyenne generale
    private fun calculerMoyenneGenerale(): Float {
        return if (notes.isNotEmpty()) {
            notes.values.sum() / notes.size
        } else {
            0f // 0 si aucune note n'est disponible
        }
    }

    // Methode pour deduire la mention
    private fun deduireMention(): String {
        return when {
            moyenneGenerale >= 16 -> "Très Bien"
            moyenneGenerale >= 14 -> "Bien"
            moyenneGenerale >= 12 -> "Assez Bien"
            moyenneGenerale >= 10 -> "Passable"
            else -> "Non validé"
        }
    }

    override fun toString(): String {
        val notesString = if (this.notes.isNotEmpty()) {
            this.notes.entries.joinToString("\n") { "- ${it.key} : ${it.value} / 20" }
        } else {
            "Pas de notes disponibles"
        }

        return  "******** Bulletin De Notes ********\n" +
                "Généré le : ${LocalDate.now()}\n" +
                "Nom & Prénom : ${this.etudiant.nom} ${this.etudiant.prenom}\n" +
                "Semestre : ${this.semestre}\n\n" +
                "---Notes Par Matière ---\n" +
                "$notesString\n\n" +
                "Moyenne Générale : ${this.moyenneGenerale}\n" +
                "Mention : ${this.mention}\n" +
                "******** Bulletin De Notes ********\n"
    }






}
