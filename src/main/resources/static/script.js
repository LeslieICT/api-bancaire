async function creerCompte() {

    const nom = document.getElementById("nom").value;
    const solde = parseFloat(document.getElementById("solde").value);

    if (!nom || isNaN(solde)) {
        alert("Veuillez remplir tous les champs.");
        return;
    }

    const response = await fetch("/comptes", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nomTitulaire: nom,
            soldeInitial: solde
        })
    });

    if (response.ok) {
        alert("✅ Compte créé avec succès !");
        document.getElementById("nom").value = "";
        document.getElementById("solde").value = "";
        chargerComptes();
    } else {
        alert("❌ Erreur lors de la création.");
    }
}

async function chargerComptes() {

    const response = await fetch("/comptes");
    const comptes = await response.json();

    const liste = document.getElementById("listeComptes");
    liste.innerHTML = "";

    comptes.forEach(compte => {

        const li = document.createElement("li");

        li.innerHTML = `
            <strong>Titulaire :</strong> ${compte.nomTitulaire}<br>
            <strong>ID :</strong> ${compte.id}<br>
            <strong>Solde :</strong> ${compte.solde.toFixed(2)} FCFA
        `;

        liste.appendChild(li);
    });
}

async function depot() {

    const id = document.getElementById("idDepot").value.trim();
    const montant = parseFloat(document.getElementById("montantDepot").value);

    if (!id || isNaN(montant)) {
        alert("Veuillez saisir un ID et un montant.");
        return;
    }

    const response = await fetch(`/comptes/${id}/depot`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            montant: montant
        })
    });

    if (response.ok) {
        alert("✅ Dépôt effectué avec succès !");
        document.getElementById("idDepot").value = "";
        document.getElementById("montantDepot").value = "";
        chargerComptes();
    } else {
        const erreur = await response.text();
        alert("❌ " + erreur);
    }
}

async function retrait() {

    const id = document.getElementById("idRetrait").value.trim();
    const montant = parseFloat(document.getElementById("montantRetrait").value);

    if (!id || isNaN(montant)) {
        alert("Veuillez saisir un ID et un montant.");
        return;
    }

    const response = await fetch(`/comptes/${id}/retrait`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            montant: montant
        })
    });

    if (response.ok) {
        alert("✅ Retrait effectué avec succès !");
        document.getElementById("idRetrait").value = "";
        document.getElementById("montantRetrait").value = "";
        chargerComptes();
    } else {
        const erreur = await response.text();
        alert("❌ " + erreur);
    }
}

chargerComptes();