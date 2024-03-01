declare interface MenuVo {
    code: string,
    name: string,
    nodeType:number,
    children:Array<MenuVo>
}