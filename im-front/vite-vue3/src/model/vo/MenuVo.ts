declare interface MenuVo {
    path: string,
    name: string,
    nodeType:number,
    children:Array<MenuVo>
}