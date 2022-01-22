import './App.css';
import React from 'react'
import axios from "axios";
import { useForm } from 'react-hook-form';

const CountryCases = () => {

  const { register, handleSubmit, watch, formState: { errors } } = useForm();
  const onSubmit = data => getData();

  const [amount, setAmount] = React.useState([]);

  React.useEffect(() => {
    getData();
  }, []);

  let response =0;

  const getData = () => {

    var country = watch("country");
    var countryReformatted = String(country);
    countryReformatted = countryReformatted.split(' ').join('+');
    console.log(countryReformatted);
    console.log(country);
    
    const ENDPOINT = "http://localhost:8080/cases?country="+countryReformatted;
    axios(ENDPOINT).then((response) => {
      
      var count = response.data;
      var countFormat = count.substring(1);

      setAmount(countFormat);
      console.log(amount);
    }).catch(error => {
      console.log("error rip");
      console.log(error);
    })
  }
  return (
    <div>
        <div class="header">Today's Covid cases in {watch("country")}</div>
            <hr></hr>
        <div class="amount"><p>{amount}</p></div>
        

            <form onSubmit = {handleSubmit(onSubmit)}>

              <input list="countries" {...register("country")} defaultValue={"USA"}/>
              <datalist id="countries">
                  <option value="Afghanistan" />
                  <option value="Albania" />
                  <option value="Algeria" />
                  <option value="American Samoa" />
                  <option value="Andorra" />
                  <option value="Angola" />
                  <option value="Anguilla" />
                  <option value="Antarctica" />
                  <option value="Antigua and Barbuda" />
                  <option value="Argentina" />
                  <option value="Armenia" />
                  <option value="Aruba" />
                  <option value="Australia" />
                  <option value="Austria" />
                  <option value="Azerbaijan" />
                  <option value="Bahamas" />
                  <option value="Bahrain" />
                  <option value="Bangladesh" />
                  <option value="Barbados" />
                  <option value="Belarus" />
                  <option value="Belgium" />
                  <option value="Belize" />
                  <option value="Benin" />
                  <option value="Bermuda" />
                  <option value="Bhutan" />
                  <option value="Bolivia" />
                  <option value="Bosnia and Herzegovina" />
                  <option value="Botswana" />
                  <option value="Bouvet Island" />
                  <option value="Brazil" />
                  <option value="British Indian Ocean Territory" />
                  <option value="Brunei Darussalam" />
                  <option value="Bulgaria" />
                  <option value="Burkina Faso" />
                  <option value="Burundi" />
                  <option value="Cambodia" />
                  <option value="Cameroon" />
                  <option value="Canada" />
                  <option value="Cape Verde" />
                  <option value="Cayman Islands" />
                  <option value="Central African Republic" />
                  <option value="Chad" />
                  <option value="Chile" />
                  <option value="China" />
                  <option value="Christmas Island" />
                  <option value="Cocos (Keeling) Islands" />
                  <option value="Colombia" />
                  <option value="Comoros" />
                  <option value="Congo" />
                  <option value="Congo, The Democratic Republic of The" />
                  <option value="Cook Islands" />
                  <option value="Costa Rica" />
                  <option value="Cote D'ivoire" />
                  <option value="Croatia" />
                  <option value="Cuba" />
                  <option value="Cyprus" />
                  <option value="Czech Republic" />
                  <option value="Denmark" />
                  <option value="Djibouti" />
                  <option value="Dominica" />
                  <option value="Dominican Republic" />
                  <option value="Ecuador" />
                  <option value="Egypt" />
                  <option value="El Salvador" />
                  <option value="Equatorial Guinea" />
                  <option value="Eritrea" />
                  <option value="Estonia" />
                  <option value="Ethiopia" />
                  <option value="Falkland Islands (Malvinas)" />
                  <option value="Faroe Islands" />
                  <option value="Fiji" />
                  <option value="Finland" />
                  <option value="France" />
                  <option value="French Guiana" />
                  <option value="French Polynesia" />
                  <option value="French Southern Territories" />
                  <option value="Gabon" />
                  <option value="Gambia" />
                  <option value="Georgia" />
                  <option value="Germany" />
                  <option value="Ghana" />
                  <option value="Gibraltar" />
                  <option value="Greece" />
                  <option value="Greenland" />
                  <option value="Grenada" />
                  <option value="Guadeloupe" />
                  <option value="Guam" />
                  <option value="Guatemala" />
                  <option value="Guinea" />
                  <option value="Guinea-bissau" />
                  <option value="Guyana" />
                  <option value="Haiti" />
                  <option value="Heard Island and Mcdonald Islands" />
                  <option value="Holy See (Vatican City State)" />
                  <option value="Honduras" />
                  <option value="Hong Kong" />
                  <option value="Hungary" />
                  <option value="Iceland" />
                  <option value="India" />
                  <option value="Indonesia" />
                  <option value="Iran, Islamic Republic of" />
                  <option value="Iraq" />
                  <option value="Ireland" />
                  <option value="Israel" />
                  <option value="Italy" />
                  <option value="Jamaica" />
                  <option value="Japan" />
                  <option value="Jordan" />
                  <option value="Kazakhstan" />
                  <option value="Kenya" />
                  <option value="Kiribati" />
                  <option value="Korea, Democratic People's Republic of" />
                  <option value="Korea, Republic of" />
                  <option value="Kuwait" />
                  <option value="Kyrgyzstan" />
                  <option value="Lao People's Democratic Republic" />
                  <option value="Latvia" />
                  <option value="Lebanon" />
                  <option value="Lesotho" />
                  <option value="Liberia" />
                  <option value="Libyan Arab Jamahiriya" />
                  <option value="Liechtenstein" />
                  <option value="Lithuania" />
                  <option value="Luxembourg" />
                  <option value="Macao" />
                  <option value="Madagascar" />
                  <option value="Malawi" />
                  <option value="Malaysia" />
                  <option value="Maldives" />
                  <option value="Mali" />
                  <option value="Malta" />
                  <option value="Marshall Islands" />
                  <option value="Martinique" />
                  <option value="Mauritania" />
                  <option value="Mauritius" />
                  <option value="Mayotte" />
                  <option value="Mexico" />
                  <option value="Moldova" />
                  <option value="Monaco" />
                  <option value="Mongolia" />
                  <option value="Montserrat" />
                  <option value="Morocco" />
                  <option value="Mozambique" />
                  <option value="Myanmar" />
                  <option value="Namibia" />
                  <option value="Nauru" />
                  <option value="Nepal" />
                  <option value="Netherlands" />
                  <option value="Netherlands Antilles" />
                  <option value="New Caledonia" />
                  <option value="New Zealand" />
                  <option value="Nicaragua" />
                  <option value="Niger" />
                  <option value="Nigeria" />
                  <option value="Niue" />
                  <option value="Norfolk Island" />
                  <option value="Northern Mariana Islands" />
                  <option value="Norway" />
                  <option value="Oman" />
                  <option value="Pakistan" />
                  <option value="Palestine " />
                  <option value="Panama" />
                  <option value="Papua New Guinea" />
                  <option value="Paraguay" />
                  <option value="Peru" />
                  <option value="Philippines" />
                  <option value="Pitcairn" />
                  <option value="Poland" />
                  <option value="Portugal" />
                  <option value="Puerto Rico" />
                  <option value="Qatar" />
                  <option value="Reunion" />
                  <option value="Romania" />
                  <option value="Saint Lucia" />
                  <option value="Samoa" />
                  <option value="San Marino" />
                  <option value="Sao Tome and Principe" />
                  <option value="Saudi Arabia" />
                  <option value="Senegal" />
                  <option value="Seychelles" />
                  <option value="Singapore" />
                  <option value="Slovakia" />
                  <option value="Slovenia" />
                  <option value="Somalia" />
                  <option value="South Africa" />
                  <option value="Spain" />
                  <option value="Sri Lanka" />
                  <option value="Sudan" />
                  <option value="Suriname" />
                  <option value="Sweden" />
                  <option value="Switzerland" />
                  <option value="Taiwan" />
                  <option value="Tajikistan" />
                  <option value="Tanzania" />
                  <option value="Thailand" />
                  <option value="Timor-leste" />
                  <option value="Togo" />
                  <option value="Tokelau" />
                  <option value="Tonga" />
                  <option value="Trinidad and Tobago" />
                  <option value="Tunisia" />
                  <option value="Turkey" />
                  <option value="Turkmenistan" />
                  <option value="Tuvalu" />
                  <option value="Uganda" />
                  <option value="Ukraine" />
                  <option value="UAE" />
                  <option value="UK" />
                  <option value="USA" />
                  <option value="Uruguay" />
                  <option value="Uzbekistan" />
                  <option value="Venezuela" />
                  <option value="Vietnam" />
                  <option value="Virgin Islands, British" />
                  <option value="Virgin Islands, U.S" />
  
                  <option value="Zambia" />
                  <option value="Zimbabwe" />
              </datalist>
            </form>
    </div>
  );
}

export default CountryCases;
