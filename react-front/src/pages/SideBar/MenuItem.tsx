import {ReactNode} from "react";
import HomeIcon from '@mui/icons-material/Home';
import LibraryBooksIcon from '@mui/icons-material/LibraryBooks';

export interface MenuItem {
    label: string,
    index: number,
    path: string,
    icon?: ReactNode,
    iconColor?: string,
}

export const menuItem: MenuItem[] = [
    {
        label: 'Home',
        index: 0,
        path: '/',
        icon: <HomeIcon />,
        iconColor: 'blue'
    },
    {
        label: '蔵書一覧',
        index: 1,
        path: '/bookList',
        icon: <LibraryBooksIcon />,
        iconColor: 'blue'
    },
]