using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
namespace QuanLyPhongTro.Models.Domain
{
    public class Disable
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Key]
        public int Id { get; set; }
        public byte disabled { get; set; }
        public DateTime Date { get; set; }
        public BaiDang baidang { get; set; }

    }
}
