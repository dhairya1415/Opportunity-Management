export interface Audit {
    audid: number,
    user_name: string,
    user_email: string,
    timestamp: string,
    oppid: number,
    action: string,
    initial: string,
    updated: string
}