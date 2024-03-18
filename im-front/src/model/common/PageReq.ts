declare interface PageReq<T> {
    page: number,
    size: number,
    current:number,
    query:T
}