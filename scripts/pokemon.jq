[to_entries | .[] | {id: .value.id, name: .key, types: [.value.types.[].type.name], sprite: (.value.id | tostring | . + ".png")}]
