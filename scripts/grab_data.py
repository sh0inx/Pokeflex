import json
import requests
import time
MAX_POKEMON_ID = 809
pokemon_dict = {}
pokemon_names = [x["name"] for x in requests.get("https://pokeapi.co/api/v2/pokemon?limit=809=&offset=0").json()["results"]]
def grab_pokemon_data(name: str, id: int) -> dict:
    # print(f'https://pokeapi.co/api/v2/pokemon/{id}/')
    pokemon_name = name
    pokemon_response = requests.get(f'https://pokeapi.co/api/v2/pokemon/{id}/')
    if pokemon_response.ok:
        return {pokemon_name: pokemon_response.json()}
    else: 
        grab_pokemon_data(id, name)
for x in zip(pokemon_names, range(1,MAX_POKEMON_ID+1)):
    time.sleep(0.7)
    try:
        pokemon_dict.update(grab_pokemon_data(x[0], x[1]))
    except:
        print("exception found, waiting 30s")
        time.sleep(30)
    print(x[1])
with open("pokemon.json", "w+") as file: 
    file.write(json.dumps(pokemon_dict))