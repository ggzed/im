declare interface PageRes<T> {
    total: number,
    size: number,
    current:number,
    totalPages:number,
    records:Array<any>
}