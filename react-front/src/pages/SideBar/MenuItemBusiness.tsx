import {ReactNode} from "react";
import AddIcon from '@mui/icons-material/Add';

export interface MenuItemBusiness {
    label: string,
    index: number,
    path: string,
    icon?: ReactNode,
    iconColor?: string,
}

export const menuItemBusiness: MenuItemBusiness[] = [
    {
        label: '本の登録',
        index: 1,
        path: '/addBook',
        icon: <AddIcon />,
        iconColor: 'blue'
    },
]