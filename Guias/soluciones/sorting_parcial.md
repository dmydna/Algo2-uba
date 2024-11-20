Ejercicios de Parciales


1. __MasContaminados__:

Se cuenta con un sistema de seguimiento de contaminacion ambiental que cubre toda la ciudad de Buenos Aires
Asi, regularmente se registra informacion de diferentes sensores en diferentes momentos y se quiere saber en que
zonas se registra mayor contaminacion, ya que cada sensor esta asociado a una zona particular de la urbe.
De esta forma, dados ciertos registros realizados, que consta del identificador del sensor, que es un valor
alfanumerico de maximo 64 caracteres, el momento en que se tomo el registro y el valor medido, donde ambos
son naturales no acotados,se quiere obtener el acumulado de cada sensor para las ultimas k mediciones (se
puede considerar cualquier valor de k, en tanto se tiene una gran cantidad de registros por cada sensor). Con
esta informacion se desa hacer un ranking, donde aprezcan primer los sensores con mauor contaminacion
registrada acumulada. En caso de empate, se mostraran primero los sensores con registros mas recientes.

Se quiere implementr la funcion MasContaminados, que recibe un arreglo que contiene mediciones de los 
sensores y la cantidad de mediciones que se desean considerar para obtener un acumulado, y se desea obtener
un ranking, donde primero aparecen los sensores que tiene mayor valor total:

```
A = [(1AB, 8, 100), (48A, 10, 100), (1AB, 9, 25), (48A, 9, 25), 
(1AB, 14, 95), (48A, 15, 20), (1C, 12, 5), (1C, 17, 50)]
```
a) Se pide escribir el algoritmo de MasContaminados, Jusficando detalladamente la complejidad.<br>
b) ¿Cual seria el mejor caso para este algoritmo? ¿Cual seria la cota de complejidad mas ajustada?


<details><summary><b>💡 solucion</b></summary>
<hr>

__Algoritmo masContaminados__:

  0. Ordeno por segunda componente (decreciciente por tiempo mas reciente) el arreglo A, lo hago con mergeSort por su complijidad O (n log n)
  1. creo un diccTrie vacio, lo uso por su costo O(1), pues sensor_id esta acotado con max 64 chars
  2. separo en dos casos. // O(1)
       - sensor esta definido: actualizo valor, agrego a lista de tuplas  < sensor, t, v > y incremento el k y checkeo si k=k 
       para dejar de agregar mediciones.
       - sensor no esta definido : defino valor como < k=0, arreglo de tuplas de mediciones> donde k son las cantidad de mediciones
       que voy a agregar segundo el k recibido por parametro
  3. hay que transferir las tuplas a un array O(n) y luego ordenar
       - usamos un iterador para recorrer el diccTrie // O(n)
  4. ordenamos con MergeSort por primera coordenada (valor de contaminacion) y luego por segunda coordenada (por tiempo mas reciente)


**aclaraciones**: hay que usar mergeSort por su complejidad y por que es estable, ya que necesito ordenar por dos criterios.

```

masContaminados(in a: Array<struct<sensor: string, in t: int, in v: int>>, in k: int): Array<string>
    

   mergeSort(A) // por segunda componente (decreciciente por tiempo mas reciente )
   d = new dictTrie()


   // armo los buckets con las ultimas k mediciones (los t mas grandes)
   for i...tam(A)
      sensor = A[i]_0
      tiempo = A[i]_1
      valor =  A[i]_2

      if !( esta(d, A[i])  // O(1)
        definir(d, sensor , < k = 0, 
                              mediciones = new array(tamaño k)<sensor: string, t:int, v:int>
      else
        // actualizar sensor
       sensor = obtener(d, sensor)  // O(1)
        if ( sensor.k  <  k)        // O(1)
          sensor.mediciones[cap] = < sensor, tiempo, valor >   
          sensor.k ++
      endif

   endfor
  
  it = new d.iterador()
  res = it.Siguiente

  while it.haySig                // O(n)
      res.concat(it.Siguiente)
  endwhile
  
  mergeSort(res) // por tercer componente (valor contaminacion)  O( n log n )
  mergeSort(res) // por segunda componente (tiempo mas reciente) o( n log n )
  
  return res
```

<hr>
</details>
    

