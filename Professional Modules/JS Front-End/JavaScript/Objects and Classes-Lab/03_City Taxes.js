function cityTaxes(name,population,treasury){

    return{
        name,
        population,
        treasury,
        taxRate: 10,

        collectTaxes() {
            this.treasury+=this.population*this.taxRate;
            this.treasury=Math.floor(this.treasury)
        },

        applyGrowth (percantage) {
            this.population+=(this.population*percantage)/100;
            this.population=Math.floor(this.population)
        },
        
        applyRecession (percantage) {
            this.treasury-=(this.treasury*percantage)/100
            this.treasury=Math.floor(this.treasury)
        }
    }

}

const city =
cityTaxes('Tortuga',
7000,
15000);
city.collectTaxes();
console.log(city.treasury);
city.applyGrowth(5);
console.log(city.population);

