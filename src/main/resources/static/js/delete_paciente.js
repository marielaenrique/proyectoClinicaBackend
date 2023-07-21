function deleteBy(id) {

    const url = '/pacientes/'+ id;
    const settings = {
        method: 'DELETE'
        }

    fetch(url,settings)
    .then(response => response.json())

    let row_id = "#tr_" + id;
    document.querySelector(row_id).remove();
    document.querySelector('#update_paciente_form').reset();
}