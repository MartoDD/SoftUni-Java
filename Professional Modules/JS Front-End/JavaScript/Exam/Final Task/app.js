function solve() {
    const baseUrl = "http://localhost:3030/jsonstore/tasks/";

    const locationInput = document.getElementById("location");
    const temperatureInput = document.getElementById("temperature");
    const dateInput = document.getElementById("date");

    const addWeatherButton = document.getElementById("add-weather");
    const editWeatherButton = document.getElementById("edit-weather");
    const loadHistoryButton = document.getElementById("load-history");

    const historyList = document.getElementById("list");

    addWeatherButton.addEventListener("click", addWeather);
    editWeatherButton.addEventListener("click", editWeather);
    loadHistoryButton.addEventListener("click", loadHistory);

    async function loadHistory() {
        historyList.innerHTML = "";

        const response = await fetch(baseUrl);
        const data = await response.json();

        for (const id in data) {
            const { location, temperature, date } = data[id];
            createWeatherRecord(id, location, temperature, date);
        }
    }

    async function addWeather(event) {
        event.preventDefault();

        const location = locationInput.value;
        const temperature = Number(temperatureInput.value);
        const date = dateInput.value;

        if (!location || !temperature || !date) {
            return;
        }

        await fetch(baseUrl, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ location, temperature, date }),
        });

        clearInputFields();
        loadHistory();
    }

    async function editWeather() {
        const id = editWeatherButton.getAttribute("data-id");

        const location = locationInput.value;
        const temperature = Number(temperatureInput.value);
        const date = dateInput.value;

        if (!location || !temperature || !date) {
            return;
        }

        await fetch(baseUrl + id, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ location, temperature, date }),
        });

        clearInputFields();
        editWeatherButton.removeAttribute("data-id");
        editWeatherButton.disabled = true;
        addWeatherButton.disabled = false;

        loadHistory();
    }

    function createWeatherRecord(id, location, temperature, date) {
        const container = document.createElement("div");
        container.className = "container";

        const locationHeading = document.createElement("h2");
        locationHeading.textContent = location;

        const dateHeading = document.createElement("h3");
        dateHeading.textContent = date;

        const temperatureHeading = document.createElement("h3");
        temperatureHeading.textContent = temperature;

        const buttonsContainer = document.createElement("div");
        buttonsContainer.id = "buttons-container";

        const changeButton = document.createElement("button");
        changeButton.className = "change-btn";
        changeButton.textContent = "Change";
        changeButton.addEventListener("click", () => {
            locationInput.value = location;
            temperatureInput.value = temperature;
            dateInput.value = date;

            editWeatherButton.setAttribute("data-id", id);
            editWeatherButton.disabled = false;
            addWeatherButton.disabled = true;
        });

        const deleteButton = document.createElement("button");
        deleteButton.className = "delete-btn";
        deleteButton.textContent = "Delete";
        deleteButton.addEventListener("click", () => deleteWeatherRecord(id));

        buttonsContainer.appendChild(changeButton);
        buttonsContainer.appendChild(deleteButton);

        container.appendChild(locationHeading);
        container.appendChild(dateHeading);
        container.appendChild(temperatureHeading);
        container.appendChild(buttonsContainer);

        historyList.appendChild(container);
    }

    async function deleteWeatherRecord(id) {
        await fetch(baseUrl + id, { method: "DELETE" });
        loadHistory();
    }

    function clearInputFields() {
        locationInput.value = "";
        temperatureInput.value = "";
        dateInput.value = "";
    }
}