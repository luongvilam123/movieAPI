import { useState, useEffect, createContext } from 'react'
import api from "./api/axiosConfig"
import Layout from './components/Layout.jsx'
import  {Route, Routes} from 'react-router-dom'
import Home from './components/Home'
import "./css/App.css"
import Header from './components/Header'
import Trailer from './components/Trailer'
import Reviews from './components/Reviews'

export const MoviesData = createContext();

function App() {

  const [movies, setMovies] = useState()
  const [movie, setMovie] = useState();
  const [reviews, setReviews] = useState([]);

  const getMovieData = async (movieId) => {
     
    try 
    {
        const response = await api.get(`/${movieId}`);

        const singleMovie = response.data;

        setMovie(singleMovie);

        setReviews(singleMovie.reviewIds);
        

    } 
    catch (error) 
    {
      console.error(error);
    }

  }


  const getMovies = async () => {
    try {

      const response = await api.get("/movies");

      setMovies(response.data);

      console.log(response.data)

    } catch(err) {

      console.log(err);

    }
  }
    useEffect( () => {
      getMovies()
    }, [] )
    
  return (
    <div className="App">
      <Header></Header>
      <MoviesData.Provider value={{movies}}>
        <Routes>
          <Route path='/' element={<Layout/>}>
            <Route path='/' element={<Home/>}></Route>
            <Route path= '/trailer/:ytTrailerId' element={<Trailer/>}></Route>  
            <Route path="/Reviews/:movieId" element ={<Reviews getMovieData = {getMovieData} movie={movie} reviews ={reviews} setReviews = {setReviews} />}></Route>      
          </Route>
        </Routes>
      </MoviesData.Provider>

    </div>
  )
}

export default App
