import {Box, Button, Stack, TextField} from "@mui/material";
import SendIcon from '@mui/icons-material/Send';
import SearchIcon from '@mui/icons-material/Search';
import ContentCopyIcon from '@mui/icons-material/ContentCopy';
import React, {useState} from "react";
import axios from "axios";

interface IBookInfo {
    name: string,
    author: string,
    publisher: string,
    publicationDate: string,
    isbn13: string,
    bookImgPath: string,
}

const AddBook = () => {
    const [isbn13, setIsbn13] = useState('')
    const [name, setName] = useState('')
    const [author, setAuthor] = useState('')
    const [publisher, setPublisher] = useState('')
    const [publicationDate, setPublicationDate] = useState('')
    const [displayBookImgPath, setDisplayBookImgPath] = useState<string>('')
    const [bookImgPath, setBookImgPath] = useState('')
    const [bookInfos, setBookInfos] = useState<IBookInfo[]>([])

    const handleSubmitIsbn13 = () => {
        axios.get('http://localhost:8080/biblioApp/book/img', {
            params: {
                isbn13: isbn13
            }})
            .then(res => {
                setDisplayBookImgPath(res.data.toString())
            })
            .catch(function (error) {
                // 送信失敗時の処理
                console.log(error);
            });
    }

    const handleSubmit = () => {
        const data = {
            name: name,
            author: author,
            publisher: publisher,
            publicationDate: publicationDate,
            isbn13: isbn13
        }

        axios.post('http://localhost:8080/biblioApp/book/add', data)
            .then(res => {
                setBookInfos(res.data)
            })
            .catch(function (error) {
                // 送信失敗時の処理
                console.log(error);
            });
    }

    return (
        <div>
            <h1>本の登録</h1>
            <Stack direction={'row'}>
                <Box
                    component="form"
                    sx={{'& > :not(style)': { m: 1, width: '50ch' },}}
                    noValidate
                    autoComplete="off">
                    <div><TextField
                        required fullWidth
                        id="isbn13"
                        label="ISBN13"
                        variant="standard"
                        onChange={(event) => setIsbn13(event.target.value)} />
                        <Button
                            size={"small"}
                            variant="contained"
                            endIcon={<SearchIcon />}
                            onClick={handleSubmitIsbn13}>書影検索</Button>
                    </div>
                    <div><TextField
                        fullWidth
                        id="bookImgPath"
                        label="書影URL"
                        variant="standard"
                        onChange={(event) => setBookImgPath(event.target.value)}
                        value={bookImgPath} /></div>
                    <div><TextField
                        required fullWidth
                        id="bookName"
                        label="本の題名"
                        variant="standard"
                        onChange={(event) => setName(event.target.value)} /></div>
                    <div><TextField
                        required fullWidth
                        id="author"
                        label="著者名"
                        variant="standard"
                        onChange={(event) => setAuthor(event.target.value)} /></div>
                    <div><TextField
                        required fullWidth
                        id="publisher"
                        label="出版社"
                        variant="standard"
                        onChange={(event) => setPublisher(event.target.value)} /></div>
                    <div><TextField
                        required fullWidth
                        id="publicationDate"
                        label="出版日"
                        variant="standard"
                        onChange={(event) => setPublicationDate(event.target.value)} /></div>
                    <div style={{textAlign: "center"}}>
                        <Button
                            size={"small"}
                            fullWidth
                            variant="contained"
                            endIcon={<SendIcon />}
                            onClick={handleSubmit}>登録</Button>
                    </div>
                </Box>
                <Box style={{marginLeft: "100px"}}>
                    {/*画像パスが存在する場合は、画像を表示する*/}
                    {displayBookImgPath && <img src={displayBookImgPath} alt="書影"/>}
                    {displayBookImgPath &&<p>{displayBookImgPath}</p>}
                </Box>
            </Stack>
        </div>
    )
}

export default AddBook;