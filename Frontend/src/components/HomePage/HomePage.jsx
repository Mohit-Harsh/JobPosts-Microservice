import React, { useEffect, useState } from "react";
import styles from './HomePage.module.css';
import search from '../../assets/icons8-search-96.png';
import JobCard from '../JobCard/JobCard.jsx';

import axios from "axios";
import { Link } from "react-router-dom";

export default function HomePage()
{
    
    const [jobposts,setPosts] = useState([]);


    useEffect(() => {
        async function fetchdata(){
            const data = (await axios.get("http://jobposts:8080/post/")).data;
            setPosts(data);
            console.log(data);
        }
        fetchdata();
    },[])

    async function handleSearch(event)
    {
        let text = document.getElementById(styles.search).value;
        let response = null
        if(text.length == 0)
        {
            response = await axios.get("http://jobposts:8080/post/");
        }
        else
        {
            response = await axios.get(`http://jobposts:8080/post/search/${text}`);
        }
        setPosts(response.data);
    }

    return(
        <>
            <nav className={styles.navbar} style={{margin:'auto',width:'fit-content'}}>
                    <div className={styles.nav} style={{height:"fit-content",padding:"1vw",display:"flex",justifyContent:"start",alignItems:"center"}}>
                        <h1 id={styles.h1} style={{margin: "0"}}>Jobposts</h1>
                        <div className={styles.searchdiv}>
                            <img src={search} alt="" style={{height:"1.5vw",width:"auto"}}/>
                            <input id={styles.search} type="text" onChange={handleSearch}/>
                        </div>
                        <Link to="create" style={{textDecoration:"none"}}><button id={styles.create}>Create Job</button></Link>
                    </div>
            </nav>
            <div className={styles.container} style={{margin:"1vw auto"}}>
                <div className={styles.jobdiv}>
                    
                    {jobposts.map((post,key) => <JobCard post={post} k={key}></JobCard>)}
                    
                </div>
                
            </div>
        </>
    )
}